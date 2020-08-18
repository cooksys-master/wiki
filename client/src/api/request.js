import request from '../utils/request'

export const GET = "GET"
export const POST = "POST"
// export const PUT = "PUT"
export const PATCH = "PATCH"
export const DELETE = "DELETE"
export const BASE_URL = `http://localhost:8081`

export const buildRequest = (url, method, requestBody) => {
    if (method === GET) {
      return request(url)
    }
    else {
      var myHeaders = new Headers();
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append("Access-Control-Allow-Origin", "*")
      const raw = JSON.stringify(requestBody)
      var options = {
        method: method,
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
      };
      return request(url, options)
    }
  }