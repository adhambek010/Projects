

export default function ResetButton({reset}){
    
    return(
        function resetHandle() {
            reset();
        }
        // <div className="resetButton" onClick={resetHandle}>
        //     Reset
        // </div>
    );
};