import { returnPageId, returnSubPageList, returnCreatePageType, createCredientials } from './utils'
import {
  GET,
  POST,
  DELETE,
  BASE_URL,
  buildRequest
} from './request'

export const getPage = (pageId) => {
  const url = `${BASE_URL}/page/${pageId}`
  return buildRequest(url, GET)
    .then(res => {
      return res.json()
    })
}

export const createPage = (name) => {
  const url = `${BASE_URL}/page/`
  const credentials = createCredientials()
  const parentId = returnPageId()
  const type = returnCreatePageType()
  const options = {
    credentials,
    parentId,
    name,
    type
  }
  return buildRequest(url, POST, options)
    .then(res => res.json())
    .then(res => {
      const subPageList = returnSubPageList()
      return [...subPageList, res]
    })
}

export const deletePage = () => {
  const pageId = returnPageId()
  const credentials = createCredientials()
  const url = `${BASE_URL}/page/${pageId}`
  return buildRequest(url, DELETE, credentials)
}