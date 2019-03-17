#!usr/bin/python
import os
import sys
import re
import urllib
from time import sleep
from bs4 import BeautifulSoup as bb
from threading import Thread
from FOcity import cityList
from format import dataFormat
import json
import random
def getHref(cityList):
    global sum
    sum = 0
    header = [{
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) '
                      'Chrome/68.0.3440.84 Safari/537.36'
    },
    {'User-Agent':'Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0'}]
    global fw
    fw = open('../fo.json', 'w', encoding='utf-8')
    for provinceItem in cityList.keys():
        for cityItem in cityList[provinceItem].keys():
            cityCode = cityList[provinceItem][cityItem]  # 城市对应的编码
            try:
                href = urllib.request.Request(
                    "https://search.51job.com/list/"+cityCode+",000000,0000,00,9,99,%2520,2,1.html",headers=header[random.randint(0,1)])
                b = bb(urllib.request.urlopen(href).read(), 'lxml')
                total_page = b.find('div', {'class': 'p_in'}).find('span', {'class': 'td'}).text  # 获取每个城市的总页数
                total_page=int(re.findall(r"\d+\.?\d*", total_page)[0])
                for i in range(total_page):
                    href = urllib.request.Request(
                        "https://search.51job.com/list/"+cityCode+",000000,0000,00,9,99,%2520,2,"+"%d.html"%(i),headers=header[random.randint(0,1)])
                    b = bb(urllib.request.urlopen(href).read(), 'lxml')
                    items = b.findAll('p', {'class', 't1'})
                    for item in items:
                        href = urllib.request.Request(item.find('span').find('a')['href'], headers=header[random.randint(0,1)])
                        Thread(target=getInformation, args=(
                            bb(urllib.request.urlopen(href).read(), 'lxml'),provinceItem,cityItem,sum)).start()
                        sum += 1
                    sleep(2)    #每获取一页数据就休眠2秒
            except Exception as e:
                print("1:%s"%e)
                continue
    fw.close()
    dataFormat("../fo.json")

def getInformation(item,provinceItem,cityItem,sum):
    try:
        name = item.find('div', {'class': 'cn'}).find('h1')['title']
        careerType=item.find('div',{'class':'bmsg job_msg inbox'}).find('div',{'class':'mt10'}).find('p',{'class':'fp'}).find('a').text
        careerType=careerType.replace('\r', '').replace('\n', '').replace('\t', '')
        company = item.find('div', {'class': 'cn'}).find('p', {'class': 'cname'}).find('a')['title']
        salary=item.find('div', {'class': 'cn'}).find('strong').text
        if('万/月' in salary):multiple=10000
        elif('千/月' in salary):multiple=1000
        else:multiple=10000/12
        salary = re.findall(r"\d+\.?\d*", salary)
        if(len(salary)==0):
             salaryT,salaryB=-1,-1
        elif(len(salary)==1):
             salaryT,salaryB=float(salary[0])*multiple,float(salary[0])*multiple
        else:
             salaryT, salaryB = float(salary[1])*multiple, float(salary[0])*multiple
        exp_edu_num=item.find('div', {'class': 'cn'}).find('p', {'class': 'msg ltype'})['title'].replace(u'\xa0', u' ').split('|')
        education=exp_edu_num[2].replace(' ', '')
        experience=exp_edu_num[1].replace(' ', '')
        peopleNumber =exp_edu_num[3].replace(' ', '')
        location=provinceItem + "省-" + cityItem + "市"
        information=item.find('div', {'class': 'bmsg job_msg inbox'}).text.replace(u'\xa0', u' ')
        information=information.replace('\r', '').replace('\n', '').replace('\t', '')
        print("%d:  职位名称:%s   职位类型:%s   单位:%s   薪资上限:%d   薪资下限:%d   学历要求:%s   工作经验:%s    地域:%s   需求人数:%s   详细信息:%s\n" %
               (sum,name, careerType,company,salaryT,salaryB, education, experience, location, peopleNumber,information.replace(' ','')))
        res =json.dumps(
            {name: {
                '职位类型' : careerType,'单位' : company,'薪资上限' : int(salaryT),'薪资下限' : int(salaryB),'学历要求' : education,
                '工作经验' : experience,'地域' : location,'需求人数' : peopleNumber,'详细信息' : information
             }},ensure_ascii=False,indent=2) + '\n'
        fw.write(res)
    except Exception as e:

        print("2:%s" % e)
        # fw.close()   #关闭文件
        #os._exit(0)  #结束整个程序



if __name__ == '__main__':
    threadNumber,num = 8,0
    cityData=[]
    for i in range(threadNumber): cityData.append({})
    for provinceItem in cityList.keys():
        cityData[num%threadNumber][provinceItem]=cityList[provinceItem]
        num+=1
    for data in cityData:
        Thread(target=getHref, args=(data,)).start()




