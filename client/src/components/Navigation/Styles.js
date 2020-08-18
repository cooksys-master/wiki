import styled from 'styled-components'
import { Link } from 'react-router-dom'

export const StyledLink = styled(Link)`
  margin: 5px;
  margin-bottom: 7.5px;
  text-decoration: none;
  color: black;

  &:hover {
    color: blue;
  }
`
