import React, { useState } from 'react'
import { useDispatch } from 'react-redux'

import { PopupDiv, PopupInner, LoginForm, Input } from './Styles'
import { SubmitButton, ExitButton } from '../StyledElements'

import { newPage } from '../../ducks/page.duck'

const Popup = ({ closePopup, type }) => {
  const [name, setName] = useState('')
  const dispatch = useDispatch()

  const addNewPage = e => {
    e.preventDefault()
    dispatch(newPage(name))
    closePopup()
  }
  return (
    <PopupDiv>
      <PopupInner>
        <div>
          <ExitButton onClick={closePopup}>Exit</ExitButton>
        </div>
        <LoginForm>
          <label>
            {type.subType} Name
            <br />
            <Input
              type='text'
              name='name'
              onChange={({ target }) => setName(target.value)}
            />
          </label>
          <br />
          <SubmitButton onClick={addNewPage}>Submit</SubmitButton>
        </LoginForm>
      </PopupInner>
    </PopupDiv>
  )
}

export default Popup
