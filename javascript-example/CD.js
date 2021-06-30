class CD
{
    _cdId;
    _cdName;
    
    constructor(_cdId,_cdName)
    {
        console.log('cd constructor called');
        this._cdId=_cdId;
        this._cdName=_cdName;
    }

    getDetails()
    {
        return 'cd id: '+this._cdId+' cd name: '+this._cdName;
    }
}

class SpecialEditionCD extends CD
{

    _specialFeature;

    constructor(_specialFeature)
    {
        super(100,'Titanic');
        this._specialFeature=_specialFeature;
        console.log('special edition cd constructor called');
    }
    getDetails()
    {
        return super.getDetails()+ 'special feature is: '+this._specialFeature;
    }

}

let _cd1=new SpecialEditionCD('3D');
console.log(_cd1.getDetails());



class InternationalCD extends CD
{

    _internationalFeature;

    constructor(_internationalFeature)
    {
        super(1000,'Final Destination');
        this._internationalFeature=_internationalFeature;
        console.log('international cd constructor called');
    }
    getDetails()
    {
        return super.getDetails()+ 'international feature is: '+this._internationalFeature;
    }

}

let _cd2=new InternationalCD('3D');
console.log(_cd2.getDetails());