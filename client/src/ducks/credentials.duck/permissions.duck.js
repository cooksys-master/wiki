import { LOGIN_FAILURE, LOGIN_SET_PERMISSIONS } from './login.duck'

export default (permissions = [], { type, payload }) => {
    switch (type) {
      case LOGIN_SET_PERMISSIONS:
        return payload
      case LOGIN_FAILURE:
        return []
      default:
        return permissions
    }
  }