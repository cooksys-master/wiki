import React from 'react'
import { useDispatch, useSelector } from 'react-redux'

import {
  ButtonWrapper,
  ButtonContainer,
  HeaderButton,
  StyledLink
} from './Styles'

import { getPermissions, logoutUser } from '../../ducks/credentials.duck'
import { ADMIN_PERMISSION } from '../../utils'

const HeaderButtons = () => {
  const permissions = useSelector(getPermissions)
  const dispatch = useDispatch()

  const checkPermissions = permissionsArray => {
    return permissionsArray.find(
      ({ permission }) => permission === ADMIN_PERMISSION
    )
  }

  const createUser = checkPermissions(permissions) ? (
    <ButtonContainer>
      <div>
        <HeaderButton>
          <StyledLink to='/user/create'>Create User</StyledLink>
        </HeaderButton>
      </div>
    </ButtonContainer>
  ) : null

  return (
    <div>
      <ButtonWrapper>
        <ButtonContainer>
          <div>
            <HeaderButton>Profile</HeaderButton>
          </div>
        </ButtonContainer>
        {createUser}
        <ButtonContainer>
          <div>
            <HeaderButton onClick={() => dispatch(logoutUser())}>
              Log Out
            </HeaderButton>
          </div>
        </ButtonContainer>
      </ButtonWrapper>
    </div>
  )
}

export default HeaderButtons
