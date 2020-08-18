import { PAGE_LOAD_START, PAGE_LOAD_FAILURE, PAGE_SET_TYPE } from './pageData.duck'

export default (types = {}, { type, payload }) => {
  switch (type) {
    case PAGE_SET_TYPE:
      return payload
    case PAGE_LOAD_FAILURE:
      return {}
    case PAGE_LOAD_START:
      return {}
    default:
      return types
  }
}
