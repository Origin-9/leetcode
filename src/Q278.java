public class Q278 {
    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int l = 1, r = n;
            while (l <= r){
                int mid = l + (r-l)/2;

                if(isBadVersion(mid))
                    r = mid - 1;
                else
                    l = mid + 1;
            }
            return l;
        }
    }
























    class VersionControl{
        boolean isBadVersion(int version){
            return true;
        }
    }
}
