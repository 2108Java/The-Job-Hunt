export interface Job {
    MatchedObjectId: number,
    MatchedObjectDescriptor: {
        PositionTitle: string,
        PositionLocationDisplay: string,
        OrganizationName: string,
        UserArea: {
            Details: {
                AgencyMarketingStatement: string,
                Evaluations: string,
                JobSummary: string,
                OtherInformation: string,
                Requirements: string
            },
        }
    }
}