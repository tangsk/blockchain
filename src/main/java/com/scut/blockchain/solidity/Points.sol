pragma solidity ^0.4.24;
//第三次更新，已经对操作积分方法进行地址约束
//但是还没有对设立个人用户和设立企业进行地址约束
//增加了企业跟银行兑换的操作，索引为企业id
//我现在不清楚是否部署智能合约就会调用构造函数，如果是这样，那怎么确保只有一个bank_address呢？每次部署是不是都会产生新的
//2020.6.15 18:37
contract Points{
    uint8 trade_id=0;//交易数量(id)
    uint company_num=0;//公司数量
    uint customer_num=0;//用户数量
    address bank_address; //银行地址
    
    constructor()
    public
    {
        bank_address=msg.sender;
    }
    
    struct company{
        address company_address;
        string company_name;
        uint company_id;
        uint company_points;
    }
    mapping (uint => company) companies;
    
    struct customer{
        address customer_address;
        string customer_name;
        uint customer_id;
        uint customer_points;
    }
    mapping (uint => customer) customers;
    
    modifier onlybank(){
        require(
             msg.sender == bank_address,
             "Only bank can call this."
            );
            _;
    }
    modifier onlycompany(address company_address){
        require(
             msg.sender == company_address,
             "Only company can call this."
            );
            _;
    }
    modifier onlycustomer(address customer_address){
        require(
             msg.sender == customer_address,
             "Only customer can call this."
            );
            _;
    }  
    
    event DeliverPoints(uint indexed time);//记录授信时间
    event GiveAwayPoints(uint indexed customer_id1,uint indexed customer_id2);//记录转赠用户id
    event UsePoints(uint indexed company_id,uint indexed customer_id);//记录兑换企业地址,企业跟用户兑换
    event GetPoints(uint indexed company_id,uint indexed customer_id);//记录用户购物从企业获取积分
    event AcceptPoints(uint indexed company_id);//记录企业向银行兑换
    event AddCompany(uint indexed company_id);
    event AddCustomer(uint indexed customer_id);
    
    function deliverPoints(uint company_id,uint points)//银行授信给企业
    public
    onlybank
    returns(uint time,uint8 id)
    {   
        trade_id = trade_id+1;//num_id为交易次数
        id = trade_id;//id为本次交易单号
        companies[company_id].company_points += points;

        time = now;
        emit DeliverPoints(time);
    }
    
    function giveAwayPoints(uint customer_id1,uint customer_id2,uint points)//用户1转赠积分给用户2
    public
    onlycustomer(customer_address)
    returns(uint8 id)
    {
        trade_id = trade_id+1;//num_id为交易次数
        id = trade_id;//id为本次交易单号
        address customer_address;
        customer_address = customers[customer_id1].customer_address;
        
        customers[customer_id1].customer_points -= points;//用户1减少积分
        customers[customer_id2].customer_points += points;//用户2增加积分

        emit GiveAwayPoints(customer_id1,customer_id2);
    }
    
    function usePoints(uint customer_id,uint company_id,uint points)//企业与个人兑换
    public
    onlycustomer(customer_address)
    returns(uint8 id)
    {
        trade_id = trade_id+1;//num_id为交易次数
        id = trade_id;//id为本次交易单号
        address customer_address;
        customer_address = customers[customer_id].customer_address;
        
        customers[customer_id].customer_points -= points;//用户减少积分  
        companies[company_id].company_points += points;//企业增加积分

        emit UsePoints(customer_id,company_id);
    }
    
    function getPoints(uint customer_id,uint company_id,uint points)//用户消费，从企业获得积分
    public
    onlycustomer(customer_address)
    returns(uint8 id)
    {
        trade_id = trade_id+1;//num_id为交易次数
        id = trade_id;//id为本次交易单号
        address customer_address;
        customer_address = customers[customer_id].customer_address;

        customers[customer_id].customer_points += points;//用户获得积分 
        companies[company_id].company_points -= points;//企业减少积分

        emit GetPoints(customer_id,company_id);
    }
    
    function acceptPoints(uint company_id,uint points)//企业跟银行兑换，企业减少积分
    public
    onlycompany(company_address)
    returns(uint8 id)
    {
        trade_id = trade_id+1;//num_id为交易次数
        id = trade_id;//id为本次交易单号
        address company_address;
        company_address = companies[company_id].company_address;
        
        companies[company_id].company_points -= points;//企业减少积分

        emit AcceptPoints(company_id);
    }
    
    function addCompany(string company_name)//设立企业
    public
    returns(uint company_id)
    {   
        company_num=company_num+1;
        company_id =company_num;
        address company_address = msg.sender;//信息发送者设定为企业
        companies[company_id] = company(company_address,company_name,company_id,0);

        emit AddCompany(company_id);
    }
    
    function addCustomer(string customer_name)//设立用户
    public
    returns(uint customer_id)
    {
        customer_num=customer_num+1;
        customer_id =customer_num;
        address customer_address = msg.sender;//信息发送者设定为个人
        customers[customer_id] = customer(customer_address,customer_name,customer_id,0);
        
        emit AddCustomer(customer_id);
    }
}
