import React, { useState } from 'react'
import { useDispatch, useSelector } from 'react-redux'

import { PageWrapper } from '../StyledElements'
import Navigation from '../Navigation'
import Content from '../Content'
import CreatePage from '../CreatePage'

import {getPageData, getPage, getType } from '../../ducks/page.duck'

const HOME_PAGE_ID = 1

const Page = ({ match }) => {
  const pageData = useSelector(getPage)
  const type = useSelector(getType)
  const dispatch = useDispatch()

  const [showPopup, setShowPopup] = useState(false)

  const pageId = match.params.pageId ? match.params.pageId : HOME_PAGE_ID

  if (Number(pageId) !== pageData.id) {
    dispatch(getPageData(pageId))
  }

  const togglePopup = () => {
    setShowPopup(!showPopup)
  }


  const popup = showPopup 
    ? <CreatePage closePopup={togglePopup} type={type} />
    : null

  const sideBar = type.hasSubType ? <Navigation createPageButton={togglePopup} type={type} /> : null

  return (
      <PageWrapper >
        {popup}
        {sideBar}
        <Content
          pageName={pageData.name}
          pastPageId={pageData.parentId} 
        />
      </PageWrapper>
  )
}

export default Page
