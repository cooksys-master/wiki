const types = {
    home: {
        typeName: "Home",
        subType: "Company",
        subTypes: "Companies",
        hasSubType: true
    },
    company: {
        typeName: "Company",
        subType: "Team",
        subTypes: "Teams",
        hasSubType: true
    },
    team: {
        typeName: "Team",
        subType: "Project",
        subTypes: "Projects",
        hasSubType: true
    },
    project: {
        typeName: "Project",
        subType: null,
        subTypes: null,
        hasSubType: false
    }
}

export const returnType = (pageDate) => {
    const type = pageDate.type.toLowerCase()
    return types[type]
}