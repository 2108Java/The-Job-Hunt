export interface Job {
    MatchedObjectId: number,
    MatchedObjectDescriptor: {
        PositionTitle: string,
        PositionLocation: {
            LocationName: string
        },
        OrganizationName: string,
        PositionSchedule: {
            Name: string
        },
        PositionFormattedDescription: {
            Content: string,
            Label: string
        },
        UserArea: {
            Details: {
                MajorDuties: string
            },
        }
    }
}