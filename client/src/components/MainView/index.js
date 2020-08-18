import React from 'react'
import { Route, Switch } from 'react-router-dom'

import { Main } from './Styles'
import Header from '../Header'
import Page from '../Page'
import CreateUser from '../CreateUser'
import Archive from '../Archive'

const MainView = () => {

  return (
    <Main>
      <Header />
      <Switch>
        <Route exact path='/user/create' component={CreateUser} />
        <Route exact path='/archive/:pageId?' component={Archive} />
        <Route path='/:pageId?' component={Page} />
      </Switch>
    </Main >
  )
}

export default MainView
