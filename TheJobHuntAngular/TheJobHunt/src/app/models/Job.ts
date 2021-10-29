export interface MajorDuties{
    0: string
}

export interface Job {
    MatchedObjectId: number,
    MatchedObjectDescriptor: {
        PositionTitle: string,
        PositionLocationDisplay: string,
        OrganizationName: string,
        DepartmentName: string,
        UserArea: {
            Details: {
                AgencyContactEmail: string
                AgencyContactPhone: string
                AgencyMarketingStatement: string,
                DrugTestRequired: string,
                Evaluations: string,
                HowToApply: string,
                JobSummary: string,
                MajorDuties: MajorDuties[],
                OtherInformation: string
                Relocation: string
                RequiredDocuments: string,
                Requirements: string,
                SecurityClearance: string,
                WhatToExpectNext: string

            },
        }
    }
}