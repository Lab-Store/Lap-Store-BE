from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.chrome.service import Service

# 브라우저 꺼짐 방지
chrome_options = Options()
chrome_options.add_experimental_option("detach", True)

# 크롬 드라이버 자동 업데이트
from webdriver_manager.chrome import ChromeDriverManager

service = Service(executable_path=ChromeDriverManager().install())
driver = webdriver.Chrome(service=service, options=chrome_options)

# 웹페이지 해당 주소 이동
url = "https://www.naver.com"
driver.get(url)

item_selector = "#content > div > div.homePageResponsive_best_wrap__3KGye > div > div > ul > li > div > div:nth-child(2) > strong"
price_selector = "#content > div > div.homePageResponsive_best_wrap__3KGye > div > div > ul > li  > div > div.productCardResponsive_information__1HK4_ > div.productCardResponsive_price_area__3lo44 > span"

driver.get(url)

items = driver.find_elements(By.CSS_SELECTOR, item_selector)
prices = driver.find_elements(By.CSS_SELECTOR, price_selector)

print("가져온 상품 수: ", len(items))
for item, price in zip(items, prices):
    print("상품: ", item.text)
    print("가격: ", price.text)
    print()
