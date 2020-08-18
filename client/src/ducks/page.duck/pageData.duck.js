import { getPage, createPage } from '../../api'
import { returnType} from '../../utils/types'


export const PAGE_LOAD_START = 'cooksys/wiki/pageData/PAGE_LOAD_START'
export const PAGE_LOAD_FAILURE = 'cooksys/wiki/pageData/PAGE_LOAD_FAILURE'
export const PAGE_LOAD_DONE = 'cooksys/wiki/pageData/PAGE_LOAD_DONE'
export const PAGE_SUBPAGELIST_DONE = 'cooksys/wiki/pageData/PAGE_SUBPAGELIST_DONE'
export const PAGE_CONTENTLOAD_DONE = 'cooksys/wiki/pageData/PAGE_CONTENTLOAD_DONE'
export const PAGE_SET_TYPE = 'cooksys/wiki/pageData/PAGE_SET_TYPE'

export default (pageData = {}, { type, payload }) => {
  switch (type) {
    case PAGE_LOAD_DONE:
      return payload
    case PAGE_LOAD_FAILURE:
      return {}
    case PAGE_LOAD_START:
      return {}
    default:
      return pageData
  }
}


export const pageDataLoadStart = () => ({
  type: PAGE_LOAD_START,
})

export const pageDataLoadFailure = err => ({
  type: PAGE_LOAD_FAILURE,
  payload: err
})

export const pageDataLoadDone = (data) => ({
  type: PAGE_LOAD_DONE,
  payload: data
})

export const pageDataContentLoad = (data) => ({
  type: PAGE_CONTENTLOAD_DONE,
  payload: data
})

export const pageDataSubPageList = (data) => ({
  type: PAGE_SUBPAGELIST_DONE,
  payload: data
})

export const setPageType = (data) => ({
  type: PAGE_SET_TYPE,
  payload: data
})

export const getPageData = (pageId) => (dispatch, getState) => {
  dispatch(pageDataLoadStart)
  getPage(pageId)
    .then(res => {
      dispatch(setPageType(returnType(res)))
      dispatch(pageDataContentLoad(res.content))
      dispatch(pageDataSubPageList(res.subPageList))
      dispatch(pageDataLoadDone(res))

    })
    .catch(error => console.log(`Error Retrieving Page Data: ${error}`))
}


export const newPage = (pageName) => (dispatch) => {
  createPage(pageName)
    .then(res => {
      // We've already added the page to the db, we just need to add it to the SubPageList
      return dispatch(pageDataSubPageList(res))
    })
    .catch(err => console.log(err))
}
