import React, { useState, useEffect } from 'react'
import { useDispatch } from 'react-redux'
import { Redirect } from 'react-router-dom'

import ArchiveSide from './ArchiveSide'
import ArchiveMain from './ArchiveMain'
import { PageWrapper } from '../StyledElements'


import { getArchiveContent, rollbackContentByArchiveId } from '../../api'
import { setNewContent } from '../../ducks/page.duck'

const HOME_PAGE_ID = 1

const Archive = ({ match }) => {
  const [archiveData, setArchiveData] = useState([])
  const [selectedArchiveData, setSelectedArchiveData] = useState({})
  const [redirectToPage, setRedirectToPage] = useState(false)

  const dispatch = useDispatch()

  const pageId = match.params.pageId ? match.params.pageId : HOME_PAGE_ID

  useEffect(() => {
    const sendGetArchive = (pageId) => {
      getArchiveContent(pageId)
        .then(res => {
          if (res.length !== 0) {
            setSelectedArchiveData(res[0])
            return setArchiveData(res)
          }
        })
        .catch(err => console.log(err))
    }

    const pageId = match.params.pageId
    sendGetArchive(pageId)
  }, [match])

  const rollback = () => {
    rollbackContentByArchiveId(selectedArchiveData.id)
      .then(res => {
        dispatch(setNewContent(selectedArchiveData.content))
      })
      .then(res => {
        setRedirectToPage(true)
      })
      .catch(err => console.log(err))
  }

  const redirect = redirectToPage ? <Redirect push to={`/${pageId}`} /> : null

  return (
    <PageWrapper>
      {redirect}
      <ArchiveSide archiveList={archiveData} setArchive={setSelectedArchiveData} />
      <ArchiveMain archiveData={selectedArchiveData} rollback={rollback} pageId={pageId} />
    </PageWrapper>
  )
}

export default Archive