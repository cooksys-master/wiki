import { LOGIN_SUCCESS, LOGIN_FAILURE } from './login.duck'

export default (error = false, { type, payload }) => {
  switch (type) {
    case LOGIN_SUCCESS:
      return false
    case LOGIN_FAILURE:
      return true
    default:
      return error
  }
}