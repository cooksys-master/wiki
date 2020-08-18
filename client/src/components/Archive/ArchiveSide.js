import React from 'react'
import styled from 'styled-components'

import { InnerContainer, SideSelectDiv, TopContainer } from '../StyledElements'
import { LeftSideContainer } from '../Containers'

const A = styled.a`
  padding-top: 15px;
  text-decoration: none;
  color: black;

  &:hover {
    color: blue;
    cursor: pointer;
  }
`

const ArchiveSide = ({ archiveList, setArchive }) => {
  const buildArchiveList = () => {
    return archiveList.map(val => {
      return (
        <A key={val.id} onClick={() => setArchive(val)}>
          Verions:{val.id}
        </A>
      )
    })
  }

  const archiveSelectionList =
    archiveList.length === 0 ? null : buildArchiveList()

  return (
    <LeftSideContainer>
      <TopContainer>Select Verion</TopContainer>
      <InnerContainer>
        <SideSelectDiv>{archiveSelectionList}</SideSelectDiv>
      </InnerContainer>
    </LeftSideContainer>
  )
}

export default ArchiveSide
