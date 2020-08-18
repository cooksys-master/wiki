import React from 'react'
import { useSelector } from 'react-redux'

import { StyledLink } from './Styles'
import { LeftSideContainer } from '../Containers'
import { Button, InnerContainer, SideSelectDiv, TopContainer } from '../StyledElements'
import { getSubPageList } from '../../ducks/page.duck'

const Navigation = ({ createPageButton, type }) => {
  const subPageList = useSelector(getSubPageList)

  const buildNamesLinksArray = () => {
    return subPageList.map(val => {
      return <StyledLink key={val.id} to={'/' + val.id} >{val.name}</StyledLink>
    })
  }

  const createName = type.subType
  const headerName = type.subTypes
  const namesLinksArray = subPageList.length === 0 ? null : buildNamesLinksArray()

  return (
    <LeftSideContainer>
      <TopContainer>
        {headerName}
        <br />
        <Button onClick={createPageButton}>Create {createName}</Button>
      </TopContainer>
      <InnerContainer>
        <SideSelectDiv>
          {namesLinksArray}
        </SideSelectDiv>
      </InnerContainer>
    </LeftSideContainer>
  )
}

export default Navigation
