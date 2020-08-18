import { createCredientials} from './utils'
import {
  POST,
  BASE_URL,
  buildRequest
} from './request'


export const loginUser = () => {
  const url = `${BASE_URL}/user/login`
  const credentials = createCredientials()
  const data = {
    username: credentials.username,
    password: credentials.password
  }
  return buildRequest(url, POST, data)
    .then(res => res.json())

}

export const createUser = (username, password, firstName, lastName, email, phoneNumber) => {
  const url = `${BASE_URL}/user`
  const options = {
    credentials: {
      username,
      password
    },
    profile: {
      firstName,
      lastName,
      email,
      phoneNumber
    }
  }
  return buildRequest(url, POST, options)
}