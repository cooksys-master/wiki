import { LOGOUT, LOGIN_FAILURE } from './login.duck'

export const SET_PASSWORD = "cooksys/wiki/login/SET_PASSWORD"

export default (password = '' , { type, payload }) => {
  switch (type) {
    case SET_PASSWORD:
      return payload
    case LOGOUT:
      return ''
    case LOGIN_FAILURE:
      return ''
    default:
      return password
  }
}

export const setStatePassword = (password) => ({
  type: SET_PASSWORD,
  payload: password
})

