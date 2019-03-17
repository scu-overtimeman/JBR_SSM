import json
import os
import random
import re
import sys
import urllib
from threading import Thread
from bs4 import BeautifulSoup as bb
from LiePincity import cityList
from format import dataFormat

def getHref(cityList):
    global sum
    sum = 0
    header = [{
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) '
                      'Chrome/68.0.3440.84 Safari/537.36'
    },{'User-Agent': 'Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0'}]
    global fw
    fw = open('../leiPin.json', 'w', encoding='utf-8')
    for provinceItem in cityList.keys():   #每一个省份
        for cityItem in cityList[provinceItem].keys():    #每一个城市
            cityCode=cityList[provinceItem][cityItem]   #城市对应的编码
            nextPage = "https://www.liepin.com/zhaopin/?dqs=%s&curPage=1"%(cityCode)
            while(True):   #遍历每一页
                try:
          #          href = urllib.request.Request(("https://www.liepin.com/zhaopin/?dqs=%s&curPage=%s")%(cityCode,i+1),headers=header[random.randint(0,1)])  # 伪装浏览器
                    href = urllib.request.Request(nextPage,headers=header[random.randint(0, 1)])  # 伪装浏览器
                    b = bb(urllib.request.urlopen(href).read(), 'lxml')
                    items = b.find('ul', {'class': 'sojob-list'}).findAll('li')  # 每一页对应的工作列表
                    for item in items:
                        href = urllib.request.Request(
                            item.find('div', {'class': 'job-info'}).find('h3').find('a')['href'],
                            headers=header[random.randint(0, 1)])
                        Thread(target=getInformation, args=(
                            bb(urllib.request.urlopen(href).read(), 'lxml'), provinceItem, cityItem, sum)).start()
                        sum += 1
                    nextPage = "https://www.liepin.com/" + b.find('div', {'class': 'pagerbar'}).findAll('a')[-3]['href']
                except Exception as e:
                    if (str(e) == 'HTTP Error 404: Not Found'):
                        break;
                    print("1:%s"%e)
                    continue

def getInformation(item,provinceItem,cityItem,sum):
    try:
        name = item.find('div', {'class': 'title-info'}).find('h1').text
        careerType=item.find('div', {'class': 'title-info'}).find('h1').text
        company = item.find('div', {'class': 'title-info'}).find('h3').find('a').text
        salary = re.findall(r"\d+\.?\d*", item.find('p', {'class': 'job-item-title'}).text)
        if(len(salary)<2):
            salaryT,salaryB=-1,-1
        elif(len(salary)==2):
            salaryT,salaryB=int(salary[0])*10000/12,int(salary[0])*10000/12
        else:
            salaryT, salaryB = int(salary[1])*10000/12, int(salary[0])*10000/12
        edu_exp_num=item.find('div', {'class': 'job-qualifications'}).findAll('span')
        if(len(edu_exp_num)==0):       #该网页源码格式不对，不获取该网页信息
            sys.exit()
        education=edu_exp_num[0].text
        experience=edu_exp_num[1].text
        peopleNumber ="1"
        location=provinceItem + "省-" + cityItem + "市"
        information=item.find('div', {'class': 'content content-word'}).text\
                        .replace('\r', '').replace('\n', '').replace('\t', '').replace(' ', '')
        print("%d:  职位名称:%s   职位类型:%s   单位:%s   薪资上限:%d   薪资下限:%d   学历要求:%s   工作经验:%s    地域:%s   需求人数:%s   详细信息:%s\n" %
              (sum,name, careerType,company,salaryT,salaryB, education, experience, location, peopleNumber, information))
        res =json.dumps(
            {name: {
                '职位类型' : careerType,'单位' : company,'薪资上限' : int(salaryT),'薪资下限' : int(salaryB),'学历要求' : education,
                '工作经验' : experience,'地域' : location,'需求人数' : peopleNumber,'详细信息' : information
             }},ensure_ascii=False,indent=2) + '\n'

        fw.write(res)
    except Exception as e:
        print("2:%s" % e)
        fw.close()   #关闭文件
        dataFormat("../leiPin.json")
        os._exit(0)  #结束整个程序

if __name__ == '__main__':
    threadNumber,num = 8,0
    cityData=[]
    for i in range(threadNumber): cityData.append({})
    for provinceItem in cityList.keys():
        cityData[num%threadNumber][provinceItem]=cityList[provinceItem]
        num+=1
    for data in cityData:
        Thread(target=getHref, args=(data,)).start()