import json
import os
import random
import re
import sys
import urllib
from threading import Thread
from format import dataFormat
import requests
from bs4 import BeautifulSoup as bb
from BOSScity import cityList




def getHref(cityList):
    global sum
    sum = 0
    header = [
        {
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) '
                          'Chrome/68.0.3440.84 Safari/537.36'
        },
        {
            'User-Agent': 'Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0'
        }
    ]
    global fw
    fw = open('../boss.json', 'w', encoding='utf-8')
    for provinceItem in cityList.keys():   #每一个省份
        for cityItem in cityList[provinceItem].keys():    #每一个城市
            cityCode=cityList[provinceItem][cityItem]   #城市对应的编码
            for i in range(5):   #遍历每一页
                try:
                    href=urllib.request.Request(("https://www.zhipin.com/c%s/?page=%s")%(cityCode,i+1),headers=header[random.randint(0,1)])  #伪装浏览器
                    b = bb(urllib.request.urlopen(href).read(), 'lxml')
                    items=b.find('div',{'class':'job-list'}).findAll('li')  #每一页对应的工作列表
                    for item in items:
                        href = urllib.request.Request(
                            "https://www.zhipin.com"+item.find('div', {'class': 'info-primary'}).find('h3').find('a')['href'],
                            headers=header[random.randint(0, 1)])
                        Thread(target=getInformation, args=(
                            bb(urllib.request.urlopen(href).read(), 'lxml'), provinceItem, cityItem, sum)).start()
                        sum += 1
                except Exception as e:
                    print("1:%s"%e)
                    continue



def getInformation(item,provinceItem,cityItem,sum):
    try:
        name = item.find('div', {'class': 'info-primary'}).find('div', {'class': 'name'}).find('h1').text
        careerType=name
        salary = re.findall(r"\d+\.?\d*", item.find('span', {'class': 'salary'}).text)
        if(len(salary)<1):
            salaryT,salaryB=-1,-1
        elif(len(salary)==1):
            salaryT,salaryB=int(salary[0]),int(salary[0])
        else:
            salaryT, salaryB = int(salary[1]), int(salary[0])
        edu_exp=item.find('div', {'class': 'info-primary'}).find('p').text
        education=edu_exp[-2:].replace("以下","初中及以下")
        experience="不限"   #有误
        peopleNumber ="1"
        location=provinceItem + "省-" + cityItem + "市"
        detailContent=item.findAll('div', {'class': 'job-sec'})
        information = item.find('div', {'class': 'job-sec'}).find('div',{'class':'text'}).text.replace(u'\xa0', u' ')
        information = information.replace('\r', '').replace('\n', '').replace('\t', '').replace(' ', '')
        company = item.find('div',{'class':'sider-company'}).find('div',{'class':'company-info'}).find('a')['title']
        company = company.replace('\r', '').replace('\n', '').replace('\t', '').replace(' ', '')
        print("%d:  职位名称:%s   职位类型:%s   单位:%s   薪资上限:%d   薪资下限:%d   学历要求:%s   工作经验:%s    地域:%s   需求人数:%s   详细信息:%s\n" %
              (sum,name, careerType,company,salaryT,salaryB, education, experience, location, peopleNumber, information))
        res =json.dumps(
            {name: {
                '职位类型' : careerType,'单位' : company,'薪资上限' : salaryT,'薪资下限' : salaryB,'学历要求' : education,
                '工作经验' : experience,'地域' : location,'需求人数' : peopleNumber,'详细信息' : information
             }},ensure_ascii=False,indent=2) + '\n'

        fw.write(res)
    except Exception as e:
        print("2:%s" % e)
        fw.close()   #关闭文件
        dataFormat("../boss.json")
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


