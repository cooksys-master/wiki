import { LOGOUT, LOGIN_FAILURE } from './login.duck'

export const SET_USERNAME = "cooksys/wiki/login/SET_USERNAME"

export default (username =  "" , {type, payload}) => {
  switch (type) {
    case SET_USERNAME:
      return payload
    case LOGOUT:
      return ''
    case LOGIN_FAILURE: 
      return ''
    default:
      return username
  }
}

export const setStateUsername = username => {
  return {
    type: SET_USERNAME,
    payload: username
  }
}


