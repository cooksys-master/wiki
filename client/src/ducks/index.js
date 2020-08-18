import { combineReducers } from 'redux'

import credentials from './credentials.duck'
import page from './page.duck'


export default combineReducers({
  credentials,
  page
})


