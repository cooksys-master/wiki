import React from 'react'
import styled from 'styled-components'


export const NavigationWrapper = styled.div`
  width: ${({ left }) => left ? '20%' : '90%'};
  height: 100%;
`
export const BlockContainer = styled.div`
  width: 90%;
  margin-left: 5%;
  background: #F79D28;
  height: 100%;
  color: white;
  font-size: 20pt;
`

export const LeftSideContainer = ({ children }) => {
  return (
    <NavigationWrapper left>
      <BlockContainer>
        {children}
      </BlockContainer>
    </NavigationWrapper>
  )
}

export const RightSideContainer = ({ children }) => {
  return (
    <NavigationWrapper>
      <BlockContainer>
        {children}
      </BlockContainer>
    </NavigationWrapper>
  )
}
