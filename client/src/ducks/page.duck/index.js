import { combineReducers } from 'redux'

import pageData from './pageData.duck'
import error from './error.duck'
import errorMessage from './errorMessage.duck'
import subPageList from './subPageList.duck'
import content from './content.duck'
import type from './type.duck'

import { getPageData , newPage} from './pageData.duck'
import { setNewContent } from './content.duck'

export { getPageData, setNewContent, newPage }

export default combineReducers({
  pageData,
  error,
  errorMessage,
  subPageList,
  content,
  type
})

export const getPage = ({ page }) => page.pageData
export const getPageName = ({ page }) => page.pageData.name
export const getError = ({ page }) => page.error
export const getErrorMessage = ({ page }) => page.errorMessage
export const getSubPageList = ({ page }) => page.subPageList
export const getContent = ({ page }) => page.content
export const getType = ({ page }) => page.type