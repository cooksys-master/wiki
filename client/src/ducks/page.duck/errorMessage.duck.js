import { PAGE_LOAD_START, PAGE_LOAD_FAILURE, PAGE_LOAD_DONE } from './pageData.duck'

export default (errorMessage = '', { type, payload }) => {
  switch (type) {
    case PAGE_LOAD_DONE:
      return ''
    case PAGE_LOAD_FAILURE:
      return payload
    case PAGE_LOAD_START:
      return ''
    default:
      return errorMessage
  }
}