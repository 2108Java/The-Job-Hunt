export class SavedJob {
    constructor(
        public savedJobId: number,
        public userId: number,
        public jobId: number,
        public appliedFor: boolean
    ){  }
}