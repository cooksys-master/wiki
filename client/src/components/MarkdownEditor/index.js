import React from "react";
import "react-mde/lib/styles/css/react-mde-all.css";

import { Editor, StyledReactMde } from './Styles'

const MarkdownEditor = (props) => {

  const [selectedTab] = React.useState("write");

  return (
    <Editor>
      <StyledReactMde
        value={props.value}
        onChange={props.onChange}
        selectedTab={selectedTab}
        onTabChange={props.tabChange}
        autoGrow={true}
        minEditorHeight ={200}
      />
    </Editor>
  );
}

export default MarkdownEditor
