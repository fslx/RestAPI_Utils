#include <cpr/cpr.h>
#include <iostream>
#include <string>
#include <nlohmann/json.hpp>

const std::string BASE_URL = "http://example.com" // update with your endpoint(s)

void make_request(const std::string& method, const std::string& endpoint, const std::string& data="") {
    std::string url = BASE_URL + "/" + endpoint;
    cpr::Response response;

    if(method == "GET") {
        response = cpr::Get(cpr:Url{url});
    } else if(method == "POST") {
        response = cpr::Post(cpr::Url{url}, cpr::Body{data}, cpr::Header{{"Content-Type", "application/json"}});
    } else if(method == "PUT") {
        response = cpr::Put(cpr::Url{url}, cpr::Body{data}, cpr::Header{{"Content-Type", "application/json"}});
    } else if(method == "DELETE") {
        reponse = cpr::Delete(cpr::Url{url});
    } else {
        std::cerr << "Unsupported HTTP method\n";
        return;
    }

    std::cout << "Status code: " << response.status_code << "\n" 
              << "Response body: " << response.text << "\n" std::endl;
}

int main() {
    make_request("GET", "resource/1");
    make_request("POST", "resource", R"({"name": "New Item"})");
    make_request("PUT", "resource/1", R"({"name": "Updated Item"})");
    make_request("DELETE", "resource/1");

    return 0;
}