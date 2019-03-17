#!usr/bin/python
import os
import sys
import re
import threading
import urllib
from time import sleep

import requests
from bs4 import BeautifulSoup as bb
from threading import Thread
from FEcity import cityList
from FEcity import career
from format import dataFormat
import json
import random
def getHref(cityList):
    global sum,fw,proxy_list
    sum = 0
    header = [{
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) '
                      'Chrome/68.0.3440.84 Safari/537.36'
    },
    {'User-Agent':'Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0'}]
    fw = open('../fe.json', 'w', encoding='utf-8')
    for provinceItem in cityList.keys():
        for cityItem in cityList[provinceItem].keys():
            cityCode = cityList[provinceItem][cityItem]  # 城市对应的编码
            for careerItem in career.keys():  # 每种职业对应的编码加进去
                try:
               #     href = urllib.request.Request(("https://%s.58.com/%s/") % (cityCode,career[careerItem]),headers=header[random.randint(0,1)])
               #     b = bb(urllib.request.urlopen(href).read(), 'lxml')
               #     total_page = int(b.find('span', {'class': 'num_operate'}).find('i', {'class': 'total_page'}).text)  # 获取每个城市的总页数
                    for i in range(1):
                        href = requests.get(("https://%s.58.com/%s/pn%s") % (cityCode, career[careerItem], i),
                                             headers=header[random.randint(0,1)])
                        b = bb(href.text, 'lxml')
                        items = b.findAll('li', {'class', 'job_item clearfix'})
                        for item in items:
                        #    href = urllib.request.Request(item.find('div',{'class':'job_name clearfix'}).find('a')['href'], headers=header[random.randint(0,1)])
                            href = requests.get(item.find('div',{'class':'job_name clearfix'}).find('a')['href'],
                                                headers=header[random.randint(0, 1)])
                         #   Thread(target=getInformation, args=(
                         #       bb(urllib.request.urlopen(href).read(), 'lxml'),provinceItem,cityItem,sum)).start()
                            Thread(target=getInformation, args=(
                                   bb(href.text, 'lxml'),provinceItem,cityItem,sum)).start()
                            sum += 1
                        sleep(2)    #每获取一页数据就休眠2秒
                except Exception as e:
                    print("1:%s"%e)
                    continue


def getInformation(item,provinceItem,cityItem,sum):
    try:
        name = item.find('span', {'class': 'pos_name'}).text
        careerType=item.find('span', {'class': 'pos_title'}).text
        company = item.find('div', {'class': 'baseInfo_link'}).text
        salary = re.findall(r"\d+\.?\d*", item.find('span', {'class': 'pos_salary'}).text)
        if(len(salary)==0):
            salaryT,salaryB=-1,-1
        elif(len(salary)==1):
            salaryT,salaryB=int(salary[0]),int(salary[0])
        else:
            salaryT, salaryB = int(salary[1]), int(salary[0])
        edu_exp_num=item.find('div', {'class': 'pos_base_condition'}).findAll('span')
        if(len(edu_exp_num)==0):       #该网页源码格式不对，不获取该网页信息
            sys.exit()
        education=edu_exp_num[1].text.replace('学历', '')
        experience=edu_exp_num[2].text.replace('经验', '')
        peopleNumber =re.sub("\D", "",edu_exp_num[0].text)
        location=provinceItem + "省-" + cityItem + "市"
        information=item.find('div', {'class': 'des'}).text
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
        dataFormat("../fe.json")
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




