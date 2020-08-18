import { PAGE_LOAD_START, PAGE_LOAD_FAILURE, PAGE_CONTENTLOAD_DONE } from './pageData.duck'
import { updateContent } from '../../api'

const UPDATE_CONTENT = "cooksys/wikia/content/UPDATE_CONTENT"

export default (content = {}, { type, payload }) => {
  switch (type) {
    case PAGE_CONTENTLOAD_DONE:
      return payload
    case UPDATE_CONTENT:
      return payload
    case PAGE_LOAD_FAILURE:
      return {}
    case PAGE_LOAD_START:
      return {}
    default:
      return content
  }
}

export const pageUpdateContent = content => ({
  type: PAGE_LOAD_FAILURE,
  payload: content
})

export const setNewContent = (content) => (dispatch, getState) => {
  updateContent(content)
    .then(res => {
      dispatch(pageUpdateContent(res))
    })
    .catch(err => console.log(err))
}