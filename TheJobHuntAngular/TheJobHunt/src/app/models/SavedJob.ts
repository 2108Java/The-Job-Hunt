import { User } from "./User";

export interface SavedJob {
    Users: User,
    AppliedFor: boolean,
    Id: number,
    MatchedObjectId: string,
    PositionTitle: string,
    PositionLocationDisplay: string,
    OrganizationName: string,
    AgencyMarketingStatement: string,
    Evaluations: string,
    JobSummary: string,
    OtherInformation: string,
    Requirements: string
}