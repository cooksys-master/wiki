import React, { useState, useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import ReactMarkdown from 'react-markdown'
import MarkdownEditor from '../MarkdownEditor'

import { StyledLink } from './Styles'
import { Button, InnerContainer, MainContentHeader, EditorContainer, TopContainer } from '../StyledElements'
import ContentHeader from '../ContentHeader'
import { RightSideContainer } from '../Containers'

import { getContent } from '../../ducks/page.duck'
import { setNewContent } from '../../ducks/page.duck'

const MainContent = ({ pageName, pastPageId }) => {
  const [viewEditTab, setViewEditTab] = useState(false)
  const [tempContentValue, setTempContentValue] = useState('')
  const [hasEdited, setHasEdited] = useState(false)

  const contentValue = useSelector(getContent)
  const dispatch = useDispatch()

  useEffect(() => {
    setTempContentValue(contentValue.content)
    setViewEditTab(false)
    setHasEdited(false)
  }, [contentValue])

  const updateContent = () => {
    setHasEdited(false)
    setViewEditTab(false)
    dispatch(setNewContent(tempContentValue))
  }

  const updateTempContentValue = (val) => {
    setHasEdited(true)
    setTempContentValue(val)
  }

  const header = pageName ? pageName : null
  const backButton = pastPageId ? <Button><StyledLink to={'/' + pastPageId} >Back</StyledLink></Button> : null
  const main = viewEditTab
    ? <MarkdownEditor value={tempContentValue} onChange={updateTempContentValue} tabChange={() => setViewEditTab(!viewEditTab)} />
    : <ReactMarkdown source={tempContentValue} />


  return (
    <RightSideContainer>
      <TopContainer>
        <MainContentHeader>
          <span>{backButton}</span>
          <span>{header}</span>
          <ContentHeader
            viewEditTab={viewEditTab}
            hasEdited={hasEdited}
            updateContent={updateContent}
            setViewEditTab={setViewEditTab}
          />
        </MainContentHeader>
      </TopContainer>
      <InnerContainer>
        <EditorContainer>
          {main}
        </EditorContainer>
      </InnerContainer>
    </RightSideContainer>
  )
}

export default MainContent
