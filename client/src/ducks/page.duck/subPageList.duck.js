import { PAGE_LOAD_START, PAGE_LOAD_FAILURE, PAGE_SUBPAGELIST_DONE } from './pageData.duck'


export default (subPageList = [], { type, payload }) => {
    switch (type) {
      case PAGE_SUBPAGELIST_DONE:
        return payload
      case PAGE_LOAD_FAILURE:
        return []
      case PAGE_LOAD_START:
        return []
      default:
        return subPageList
    }
  }