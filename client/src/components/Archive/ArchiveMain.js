import React from 'react'
import { useSelector } from 'react-redux'
import ReactMarkdown from 'react-markdown'
import styled from 'styled-components'
import { Link } from 'react-router-dom'

import { getPageName } from '../../ducks/page.duck'

import {
  Button,
  InnerContainer,
  MainContentHeader,
  EditorContainer,
  TopContainer
} from '../StyledElements'
import { RightSideContainer } from '../Containers'

const StyledLink = styled(Link)`
  padding-top: 15px;
  text-decoration: none;
  margin-top: 5px;
  border: none;
  color: white;

`

const ArchiveMain = ({ archiveData, rollback, pageId }) => {
  const pageName = useSelector(getPageName)

  return (
    <RightSideContainer>
      <TopContainer>
        <MainContentHeader>
          <span>
            <Button>
              <StyledLink to={`/${pageId}`}>Back</StyledLink>
            </Button>{' '}
          </span>
          <span>{pageName}</span>
          <span>
            <Button onClick={rollback}>Revert This Version</Button>
          </span>
        </MainContentHeader>
      </TopContainer>
      <InnerContainer>
        <EditorContainer>
          <ReactMarkdown source={archiveData.content} />
        </EditorContainer>
      </InnerContainer>
    </RightSideContainer>
  )
}

export default ArchiveMain
