
#scraper_api.py

from flask import Flask, request, jsonify
from flask_cors import CORS  
from bs4 import BeautifulSoup
import requests

#Create Flask app
app = Flask(__name__)

CORS(app)

@app.route('/scrape_price', methods=['POST'])
def scrape_price():
    data = request.get_json()
    url = data.get('url')
    
    if not url:
        return jsonify({'error': 'Missing URL'}), 400
    
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36',
        'Accept-Language': 'en-US,en;q=0.9',
    }
    
    try:
        response = requests.get(url, headers=headers)
        soup = BeautifulSoup(response.content, 'html.parser')

        price_tag = (soup.select_one('#priceblock_ourprice') 
                     or soup.select_one('#priceblock_dealprice') 
                     or soup.select_one('.a-price .a-offscreen'))

        if price_tag:
            price_text = price_tag.get_text(strip=True).replace('$','').replace(',','')
            price = float(price_text)
            return jsonify({'price': price})
        else:
            return jsonify({'error': 'Price not found'}), 404
    except Exception as e:
        return jsonify({'error': str(e)}), 500

if __name__ == '__main__':
    app.run(port=5000, debug=True)