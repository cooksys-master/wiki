import { store } from '../index'

export const returnPageId = () => {
  const state = store.getState()
  return state.page.pageData.id
}

export const returnSubPageList = () => {
  const state = store.getState()
  return state.page.subPageList
}

export const returnCreatePageType = () => {
  const state = store.getState()
  return state.page.type.subType
}

export const createCredientials = () => {
  const state = store.getState()
  const credentials = {
    username: state.credentials.username,
    password: state.credentials.password
  }
  return credentials
}