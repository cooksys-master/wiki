import React, { useState } from 'react'

import { AppDiv, LoginForm, Input } from './Styles'
import { SubmitButton } from '../StyledElements'

import { createUser } from '../../api'

const CreateUser = () => {
  const [username, setUsername] = useState('')
  const [password, setPassword] = useState('')
  const [email, setEmail] = useState('')
  const [firstName, setFirstName] = useState('')
  const [lastName, setLastName] = useState('')
  const [phoneNumber, setPhoneNumber] = useState('')
  const [created, setCreated] = useState(false)

  const handleSubmitButton = e => {
    e.preventDefault()
    createUser(
      username,
      password,
      firstName,
      lastName,
      email,
      phoneNumber
    ).catch(err => console.log(err))

    setCreated(true)
    setUsername('')
    setPassword('')
    setEmail('')
    setFirstName('')
    setLastName('')
    setPhoneNumber('')
  }

  const createdUser = created ? <p>User has been created</p> : null

  return (
    <AppDiv>
      {createdUser}
      <LoginForm>
        <label>
          Username
          <br />
          <Input
            type='text'
            name='username'
            required
            onChange={({ target: { value } }) => setUsername(value)}
            value={username}
          />
        </label>
        <label>
          Password
          <br />
          <Input
            type='password'
            name='password'
            required
            onChange={({ target: { value } }) => setPassword(value)}
            value={password}
          />
        </label>
        <label>
          Email
          <br />
          <Input
            type='email'
            name='username'
            required
            onChange={({ target: { value } }) => setEmail(value)}
            value={email}
          />
        </label>
        <label>
          First Name
          <br />
          <Input
            type='text'
            name='firstname'
            onChange={({ target: { value } }) => setFirstName(value)}
            value={firstName}
          />
        </label>
        <label>
          Last Name
          <br />
          <Input
            type='text'
            name='lastname'
            onChange={({ target: { value } }) => setLastName(value)}
            value={lastName}
          />
        </label>
        <label>
          Phone Number
          <br />
          <Input
            type='tel'
            name='phonenumber'
            pattern='[0-9]{3}-[0-9]{3}-[0-9]{4}'
            onChange={({ target: { value } }) => setPhoneNumber(value)}
            value={phoneNumber}
          />
        </label>
        <br />
        <SubmitButton onClick={handleSubmitButton}>Create User</SubmitButton>
      </LoginForm>
    </AppDiv>
  )
}

export default CreateUser
