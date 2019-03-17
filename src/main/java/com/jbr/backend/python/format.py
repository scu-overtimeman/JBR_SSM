
import json
from IPproxy import get_href
'''
将数据文件进行格式化
'''
def dataFormat(file):
   with open(file, encoding='utf-8-sig') as load_f:
      load_dict = load_f.readlines()
   with open(file, 'w', encoding='utf-8') as load_new:
      for data in load_dict:
         data = data.strip('\n')
         data = data.replace(' ', '')
         load_new.write(data)

   with open(file, encoding='utf-8-sig') as load_f:
      load_dict = load_f.readlines()
   with open(file, 'w', encoding='utf-8') as load_new:
      for data in load_dict:
         data = data.replace("}}{", "}}\n{")
         load_new.write(data)

