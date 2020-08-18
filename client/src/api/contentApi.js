import { returnPageId, createCredientials } from './utils'
import {
  POST,
  PATCH,
  BASE_URL,
  buildRequest
} from './request'

export const updateContent = (content) => {
  const pageId = returnPageId()
  const url = `${BASE_URL}/page/content/${pageId}`
  const credentials = createCredientials()
  const data = {
    credentials,
    content
  }
  return buildRequest(url, PATCH, data)
    .then(res => res.json())
}

export const getArchiveContent = (pageId) => {
  const url = `${BASE_URL}/page/archive/${pageId}`
  const credentials = createCredientials()
  const options = {
    credentials
  }
  return buildRequest(url, POST, options)
    .then(res =>res.json())
    .then(res => [...res].reverse())
}

export const rollbackContentByArchiveId = (archiveId) => {
  const url = `${BASE_URL}/page/archive/rollback/${archiveId}`
  const credentials = createCredientials()
  const options = {
    credentials
  }
  return buildRequest(url, PATCH, options)
}
