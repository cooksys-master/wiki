import React from 'react'
import { useSelector } from 'react-redux'
import { Route, Redirect, Switch } from 'react-router-dom'
import styled from 'styled-components'

import MainView from '../MainView'
import Login from '../Login'

import { getLogin } from '../../ducks/credentials.duck'

const AppDiv = styled.div`
  text-align: center;
  min-height: 100vh;
  font-size: calc(10px + 2vmin);
  color: blue;
`

const App = () => {
  const loggedIn = useSelector(getLogin)

  const redirectToLoginPage = loggedIn ? null : <Redirect push to='/login' />

  return (
    <AppDiv >
      {redirectToLoginPage}
      <Switch>
        <Route exact path='/login' component={Login} />
        <Route path='/' component={MainView} />
      </Switch>
    </AppDiv>
  )
}

export default App
