import { LOGIN_SUCCESS, LOGIN_FAILURE } from './login.duck'


export default (errorMessage = '', { type, payload }) => {
  switch (type) {
    case LOGIN_SUCCESS:
      return ''
    case LOGIN_FAILURE:
      return payload
    default:
      return errorMessage
  }
}