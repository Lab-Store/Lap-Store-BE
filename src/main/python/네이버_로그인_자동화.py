from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys

# 브라우저 꺼짐 방지
chrome_options = Options()
chrome_options.add_experimental_option("detach", True)43

# 크롬 드라이버 자동 업데이트
from webdriver_manager.chrome import ChromeDriverManager
service = Service(executable_path=ChromeDriverManager().install())
driver = webdriver.Chrome(service=service, options=chrome_options)

import time
import pyautogui
import pyperclip

#id / pw
user_id = "1004sunye"
user_pw = "1108Qkrgks!!"

# 웹페이지 해당 주소 이동
driver.implicitly_wait(5) # 웹페이지가 로딩 될 때까지 5초는 기다림
driver.maximize_window() # 화면 최대화
url = "https://nid.naver.com/nidlogin.login?mode=form&url=https://www.naver.com/"
driver.get(url)

# 아이디 입력창
id = driver.find_element(By.CSS_SELECTOR, "#id")
id.click()
pyperclip.copy(user_id)
id .send_keys(Keys.COMMAND, "v")
# pyautogui.hotkey("command", "v")

time.sleep(2)

# 비밀번호 입력창
pw = driver.find_element(By.CSS_SELECTOR, "#pw")
pw.click()
pyperclip.copy(user_pw)
pw.send_keys(Keys.COMMAND, "v")
# pyautogui.hotkey("command", "v")

time.sleep(2)

# 로그인 버튼
login_btn = driver.find_element(By.CSS_SELECTOR, "#log\.login")
login_btn.click()



# item_selector = "#content > div > div.homePageResponsive_best_wrap__3KGye > div > div > ul > li > div > div:nth-child(2) > strong"
# price_selector = "#content > div > div.homePageResponsive_best_wrap__3KGye > div > div > ul > li  > div > div.productCardResponsive_information__1HK4_ > div.productCardResponsive_price_area__3lo44 > span"

# driver.get(url)

# items = driver.find_elements(By.CSS_SELECTOR, item_selector)
# prices = driver.find_elements(By.CSS_SELECTOR, price_selector)

# print("가져온 상품 수: ", len(items))
# for item, price in zip(items, prices):
#     print("상품: ", item.text)
#     print("가격: ", price.text)
#     print()
