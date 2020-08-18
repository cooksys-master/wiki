import React, { useState } from 'react'
import { useSelector } from 'react-redux'
import { Redirect } from 'react-router-dom'
import styled from 'styled-components'

import { StyledLink } from './Styles'
import { Button } from '../StyledElements'

import { getPermissions } from '../../ducks/credentials.duck'
import { getPage } from '../../ducks/page.duck'
import { deletePage } from '../../api'
import { HOME_PATH, ADMIN_PERMISSION } from '../../utils'

const Flex = styled.div`
    display: flex;
    justify-content: space-around;
    margin-top: 5px;
`

const P = styled.p`
    font-size: 12px;
`

const ContentHeader = ({ viewEditTab, hasEdited, updateContent, setViewEditTab }) => {
    const [hasDeleted, setHasDeleted] = useState(false)
    const userPermissions = useSelector(getPermissions)
    const pageData = useSelector(getPage)

    const deleteButtonAction = () => {
        deletePage()
            .then(res => setHasDeleted(true))
            .catch(err => console.log(err))
    }

    const checkPermissionAndHomePage = (permissionsArray) => {
        const permissionCheck = permissionsArray.find(({ permission }) => permission === ADMIN_PERMISSION)
        const homePageCheck = pageData.id === 1
        return homePageCheck ? false : permissionCheck
    }

    const checkPermission = (permissionsArray) => {
        return permissionsArray.find(({ permission }) => permission === ADMIN_PERMISSION)
    }

    const editOrPreview = viewEditTab ? "Preview" : "Edit"
    const saveButton = hasEdited ? <Button onClick={() => updateContent()}>Save</Button> : null
    const deletePageButton = checkPermissionAndHomePage(userPermissions) ? <Button onClick={deleteButtonAction} >Delete </Button> : null
    const archiveButton = checkPermission(userPermissions) ? <Button><StyledLink to={`/archive/${pageData.id}`} >Archive</StyledLink> </Button> : null
    // Set to global variable

    const redirectToHome = hasDeleted ? <Redirect push to={HOME_PATH} /> : null

    return (
        < Flex >
            {redirectToHome}
            {deletePageButton}
            {archiveButton}
            <Button onClick={() => setViewEditTab(!viewEditTab)} >{editOrPreview}</Button>
            {saveButton}
            {hasEdited ? <P>Unsaved Changes</P> : null}
        </Flex >
    )
}

export default ContentHeader