import requests
import json

BASE_URL = "http://example.com"

def make_request(method, endpoint, data=None):
    url = f"{BASE_URL}/{endpoint}"
    headers = {"Content-type": "application/json"}
    try:
        if method.upper() == "GET":
            response = requests.get(url, headers=headers)
        elif method.upper() == "POST":
            response = requests.post(url, headers=headers, json=data)
        elif method.upper() == "PUT":
            response = requests.put(url, headers=headers, json=data)
        elif method.upper() == "DELETE":
            response = requests.delete(url, headers=headers)
        else:
            raise ValueError("Unsupported HTTP method")
    except requests.exceptions.RequestException as e:
        return {"Error": str(e)}

if __name__ == "__main__":
    print(make_request("GET", "resource/1"))
    print(make_request("POST", "resource", data={"Id":1 ,"name": "New item"}))
    print(make_request("PUT", "resource/1", data={"Id":1,"name":"Updated item"}))
    print(make_request("DELETE", "resource/1"))