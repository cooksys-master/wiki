import { PAGE_LOAD_START, PAGE_LOAD_FAILURE, PAGE_LOAD_DONE } from './pageData.duck'

export default (error = false, { type, payload }) => {
  switch (type) {
    case PAGE_LOAD_DONE:
      return false
    case PAGE_LOAD_FAILURE:
      return true
    case PAGE_LOAD_START:
      return false
    default:
      return error
  }
}