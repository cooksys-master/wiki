import { combineReducers } from 'redux'

import loggedIn from './login.duck'
import username from './username.duck'
import password from './password.duck'
import error from './error.duck'
import errorMessage from './errorMessage.duck'
import permissions from './permissions.duck'

import { login, logoutUser } from './login.duck'
import { setStateUsername} from './username.duck'
import { setStatePassword} from './password.duck'

export { login, logoutUser, setStateUsername, setStatePassword }


export default combineReducers({
  loggedIn,
  username,
  password,
  error,
  errorMessage,
  permissions
})

export const getUsername = ({ credentials }) => credentials.username
export const getPassword = ({ credentials }) => credentials.password
export const getLogin = ({ credentials }) => credentials.loggedIn
export const getError = ({ credentials }) => credentials.error
export const getErrorMessage = ({ credentials }) => credentials.errorMessage
export const getPermissions = ({ credentials }) => credentials.permissions