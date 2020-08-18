import { loginUser } from '../../api'

export const LOGIN_SUCCESS = 'cooksys/wiki/login/LOGIN_SUCCESS'
export const LOGIN_FAILURE = 'cooksys/wiki/login/LOGIN_FAILURE'
export const LOGOUT = 'cooksys/wiki/LOGOUT'
export const LOGIN_SET_PERMISSIONS = 'cooksys/wiki/LOGIN_SET_PERMISSIONS'


// (genres = [], { type, payload })
export default (login = false, {type, payload}) => {
  switch (type) {
    case LOGIN_SUCCESS:
      return true
    case LOGIN_FAILURE:
      return false
    case LOGOUT:
      return false
    default:
      return login
  }
}

export const loginSuccessfull = () => ({
  type: LOGIN_SUCCESS,
})

export const loginFailure = err => ({
  type: LOGIN_FAILURE,
  payload: err
})

export const logoutUser = () => ({
  type: LOGOUT
})

export const loginUserSetPermissions = (data) => ({
  type: LOGIN_SET_PERMISSIONS,
  payload: data
})

const checkPermissions = (permissions) => {
  return  permissions ? permissions : []
}

export const login = () => (dispatch, getState) => {
  //add error handling somehow
  loginUser()
    .then(res => {
      dispatch(loginUserSetPermissions(checkPermissions(res.permissions)))
      return dispatch(loginSuccessfull())
    })
    .catch(err => {
      console.log(err)
      return dispatch(loginFailure(err))
    })
}